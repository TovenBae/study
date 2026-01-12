package controllers

import (
	"codegear.info/backend/utils"
	"github.com/gin-gonic/gin"
	"net/http"
)

// HealthCheck godoc
// @Summary Health check
// @Description Check if the server is running
// @Tags health
// @Accept json
// @Produce json
// @Success 200 {object} utils.SuccessResponse
// @Router /health [get]
func HealthCheck(c *gin.Context) {
	utils.SendSuccess(c, http.StatusOK, "Server is running", gin.H{
		"status": "healthy",
	})
}

// PingCheck godoc
// @Summary Ping check
// @Description Check API connectivity
// @Tags health
// @Accept json
// @Produce json
// @Success 200 {object} utils.SuccessResponse
// @Router /api/v1/ping [get]
func PingCheck(c *gin.Context) {
	utils.SendSuccess(c, http.StatusOK, "Pong", gin.H{
		"message": "pong",
	})
}
