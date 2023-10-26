#!/bin/sh

# Replace the placeholder with the actual value of the API_URL environment variable
sed -i 's#%%API_URL%%#'"$API_URL"'#g' /app/dist/assets/*.js

# Start the HTTP server
http-server /app/dist --spa
