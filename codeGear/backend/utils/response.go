package utils

import (
	"github.com/gin-gonic/gin"
)

// SuccessResponse represents a successful API response
type SuccessResponse struct {
	StatusCode int         `json:"statusCode"`
	Message    string      `json:"message"`
	Data       interface{} `json:"data,omitempty"`
}

// ErrorResponse represents an error API response
type ErrorResponse struct {
	StatusCode int    `json:"statusCode"`
	Message    string `json:"message"`
	Error      string `json:"error,omitempty"`
}

// SendSuccess sends a successful response
func SendSuccess(c *gin.Context, statusCode int, message string, data interface{}) {
	c.JSON(statusCode, SuccessResponse{
		StatusCode: statusCode,
		Message:    message,
		Data:       data,
	})
}

// SendError sends an error response
func SendError(c *gin.Context, statusCode int, message string, err string) {
	c.JSON(statusCode, ErrorResponse{
		StatusCode: statusCode,
		Message:    message,
		Error:      err,
	})
}
