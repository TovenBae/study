package main

import (
	"codegear.info/backend/config"
	_ "codegear.info/backend/docs"
	"codegear.info/backend/routes"
	"github.com/gin-gonic/gin"
	"log"
)

// @title CodeGear API
// @version 1.0
// @description Backend API service for codegear.info
// @termsOfService http://swagger.io/terms/

// @contact.name API Support
// @contact.url http://www.codegear.info/support
// @contact.email support@codegear.info

// @license.name MIT
// @license.url https://opensource.org/licenses/MIT

// @host localhost:8080
// @BasePath /
// @schemes http https

func main() {
	// Initialize database
	config.InitDatabase()

	// Run migrations for auth models
	config.MigrateAuthModels()

	// Set Gin to release mode (change to debug mode during development)
	// gin.SetMode(gin.ReleaseMode)
	gin.SetMode(gin.DebugMode)

	// Create router
	router := gin.Default()

	// Setup routes
	routes.SetupRoutes(router)

	// Start server
	log.Println("Server starting on port 8080...")
	if err := router.Run(":8080"); err != nil {
		log.Fatal("Failed to start server:", err)
	}
}
