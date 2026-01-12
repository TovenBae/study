package models

import (
	"time"

	"gorm.io/gorm"
)

// BaseModel contains common fields for all models
type BaseModel struct {
	ID        uint           `gorm:"primarykey" json:"id"`
	CreatedAt time.Time      `json:"createdAt"`
	UpdatedAt time.Time      `json:"updatedAt"`
	DeletedAt gorm.DeletedAt `gorm:"index" json:"-"`
}
