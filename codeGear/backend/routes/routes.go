package routes

import (
	"codegear.info/backend/controllers"
	"codegear.info/backend/middleware"
	"github.com/gin-gonic/gin"
	swaggerFiles "github.com/swaggo/files"
	ginSwagger "github.com/swaggo/gin-swagger"
)

// SetupRoutes configures all routes for the application
func SetupRoutes(router *gin.Engine) {
	// Middleware
	router.Use(middleware.CORS())
	router.Use(middleware.ErrorHandler())

	// Health check endpoint
	router.GET("/health", controllers.HealthCheck)

	// Swagger documentation
	router.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerFiles.Handler))

	// API v1 routes
	v1 := router.Group("/api/v1")
	{
		v1.GET("/ping", controllers.PingCheck)
	}
}
