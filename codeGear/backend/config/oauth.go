package config

import (
	"codegear.info/backend/models"
	"log"
)

// MigrateAuthModels runs database migrations for auth-related models
func MigrateAuthModels() {
	if err := DB.AutoMigrate(&models.User{}); err != nil {
		log.Fatal("Failed to migrate auth models:", err)
	}
	log.Println("Auth models migrated successfully")
}
