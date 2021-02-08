FROM node:15.5.1-alpine3.10
WORKDIR '/app'
COPY package.json ./
RUN npm install 
COPY . .
CMD ["npm", "run", "serve"]