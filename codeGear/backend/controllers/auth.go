package controllers

import (
	"codegear.info/backend/config"
	"codegear.info/backend/models"
	"codegear.info/backend/utils"
	"net/http"
	"time"

	"github.com/gin-gonic/gin"
	"golang.org/x/oauth2"
)

// GoogleLoginURL godoc
// @Summary Get Google OAuth login URL
// @Description Returns the Google OAuth login URL for authentication
// @Tags auth
// @Produce json
// @Success 200 {object} map[string]string
// @Router /api/auth/google/url [get]
func GoogleLoginURL(c *gin.Context) {
	config := utils.GetGoogleOAuthConfig()
	url := config.AuthCodeURL("state", oauth2.AccessTypeOffline)

	c.JSON(http.StatusOK, gin.H{
		"url": url,
	})
}

// GoogleCallback godoc
// @Summary Google OAuth callback
// @Description Handles Google OAuth callback and creates/updates user
// @Tags auth
// @Accept json
// @Produce json
// @Param code query string true "Authorization code from Google"
// @Success 200 {object} map[string]interface{}
// @Failure 400 {object} map[string]string
// @Failure 500 {object} map[string]string
// @Router /api/auth/google/callback [get]
func GoogleCallback(c *gin.Context) {
	code := c.Query("code")
	if code == "" {
		c.JSON(http.StatusBadRequest, gin.H{"error": "Code is required"})
		return
	}

	// Get user info from Google
	userInfo, err := utils.GetGoogleUserInfo(code)
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Failed to get user info"})
		return
	}

	db := config.GetDB()
	var user models.User

	// Find or create user
	result := db.Where("google_id = ?", userInfo.ID).First(&user)
	if result.Error != nil {
		// User doesn't exist, create new user
		user = models.User{
			Email:       userInfo.Email,
			Name:        userInfo.Name,
			Picture:     userInfo.Picture,
			GoogleID:    userInfo.ID,
			LastLoginAt: time.Now().Unix(),
		}
		if err := db.Create(&user).Error; err != nil {
			c.JSON(http.StatusInternalServerError, gin.H{"error": "Failed to create user"})
			return
		}
	} else {
		// User exists, update last login time
		user.LastLoginAt = time.Now().Unix()
		db.Save(&user)
	}

	// Generate JWT token
	token, err := utils.GenerateJWT(user.ID, user.Email)
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": "Failed to generate token"})
		return
	}

	c.JSON(http.StatusOK, gin.H{
		"token": token,
		"user": gin.H{
			"id":      user.ID,
			"email":   user.Email,
			"name":    user.Name,
			"picture": user.Picture,
		},
	})
}

// GetCurrentUser godoc
// @Summary Get current authenticated user
// @Description Returns the current user's information
// @Tags auth
// @Produce json
// @Security BearerAuth
// @Success 200 {object} models.User
// @Failure 401 {object} map[string]string
// @Router /api/auth/me [get]
func GetCurrentUser(c *gin.Context) {
	userID, exists := c.Get("userID")
	if !exists {
		c.JSON(http.StatusUnauthorized, gin.H{"error": "Unauthorized"})
		return
	}

	db := config.GetDB()
	var user models.User

	if err := db.First(&user, userID).Error; err != nil {
		c.JSON(http.StatusNotFound, gin.H{"error": "User not found"})
		return
	}

	c.JSON(http.StatusOK, user)
}

// Logout godoc
// @Summary Logout user
// @Description Logout the current user
// @Tags auth
// @Produce json
// @Success 200 {object} map[string]string
// @Router /api/auth/logout [post]
func Logout(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "Logged out successfully"})
}
