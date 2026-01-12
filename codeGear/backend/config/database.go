package config

import (
	"log"

	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

var DB *gorm.DB

// InitDatabase initializes the database connection
func InitDatabase() {
	var err error

	// SQLite 데이터베이스 연결
	DB, err = gorm.Open(sqlite.Open("./database/codegear.db"), &gorm.Config{})
	if err != nil {
		log.Fatal("Failed to connect to database:", err)
	}

	log.Println("Database connected successfully")
}

// GetDB returns the database instance
func GetDB() *gorm.DB {
	return DB
}
