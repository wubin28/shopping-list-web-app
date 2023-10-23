# Build stage
FROM node:lts-alpine AS build-stage

# Make the 'app' folder the current working directory
WORKDIR /app

# Copy both 'package.json' and 'package-lock.json' (if available)
COPY package*.json ./

# Install project dependencies and simple http server for serving static content
RUN npm install && npm install -g http-server

# Copy project files and folders to the current working directory (i.e. 'app' folder)
COPY . .

# Build app for production with minification
RUN npm run build

# Production stage
FROM node:lts-alpine AS production-stage

# Install simple http server for serving static content
RUN npm install -g http-server

WORKDIR /app

# Copy the built app from the build stage
COPY --from=build-stage /app/dist ./dist

EXPOSE 8080
CMD [ "http-server", "dist", "--spa" ]