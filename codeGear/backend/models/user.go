package models

// User represents a user in the system
type User struct {
	BaseModel
	Email         string `gorm:"uniqueIndex;not null" json:"email"`
	Name          string `json:"name"`
	Picture       string `json:"picture"`
	GoogleID      string `gorm:"uniqueIndex" json:"googleId,omitempty"`
	RefreshToken  string `json:"-"` // Don't expose in JSON
	LastLoginAt   int64  `json:"lastLoginAt"`
}

// TableName specifies the table name for User model
func (User) TableName() string {
	return "users"
}
