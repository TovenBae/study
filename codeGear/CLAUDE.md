# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

CodeGear is a learning project based on the tutorial from codegear.tistory.com/147. This is a sample fullstack application for educational purposes.

## Architecture

This is a monorepo containing:

- **Frontend**: Next.js application (to be located in `frontend/` directory)
- **Backend**: goLang application (to be located in `backend/` directory)
- **Database**: SQLite3

## Repository Status

This repository is currently in initial setup phase. The frontend and backend directories have not yet been created. When developing this project, follow the structure outlined in the README.md:

```
codeGear/
├── frontend/    # Next.js application
├── backend/     # Go application
└── README.md
```

## Development Commands

### Frontend (Next.js)
Once the frontend is initialized:
```bash
cd frontend
npm install          # Install dependencies
npm run dev         # Start development server
npm run build       # Build for production
npm run start       # Start production server
npm run lint        # Run linting
```

### Backend (Go)
Once the backend is initialized:
```bash
cd backend
go mod download     # Download dependencies
go run main.go      # Start development server
go build            # Build for production
go test ./...       # Run tests
```

## Reference

The project follows the tutorial and examples from: codegear.tistory.com/147
