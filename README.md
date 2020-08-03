To use this application needed:

1) create database and restore information from database dump:
psql --username yourusername --dbname yourdatabasename -f yourfile.sql (file you can download from project - new_birds_db.sql)

2) use cmd to start spring boot project:

a) go to project folder
b) write command - mvn spring-boot:run


After that you can test application by Postman. Please, use form_data in body, not row with json
