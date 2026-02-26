# Utilisation de l'image Alpine de base
FROM openjdk:21

# Définir des variables d'environnement
ENV APP_HOME=/app
#ENV FR_POMPEY_CDA23016_WEBPROJET_URLAPI=http://apiprojet:9000

# Exposer le port 9011
EXPOSE 9090

# Répertoire de travail dans le conteneur
WORKDIR $APP_HOME

# Copie du fichier JAR de votre projet dans le conteneur
COPY target/webprojet-0.0.1-SNAPSHOT.jar /app/webprojet-0.0.1-SNAPSHOT.jar

# Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "webprojet-0.0.1-SNAPSHOT.jar"]