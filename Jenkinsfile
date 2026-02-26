pipeline {
    // depuis m'importe quel agent Jenkins
    agent any
    // variables d'environment
    environment {
        // nom de mon image pour le dockerHub
        registry = "veropedro/webspringboot2026"
        // compte DockerHub paramétré sur le serveur Jenkins
        // dans la rubrique Credentials de l'administration serveur
        registryCredential = 'DockerHubAccount'
        dockerImage = ''
    }
    // déclaration des outils que l'agent devra utiliser
    // outils parametre et declare dans jenkins
    tools {
        maven 'maven'
        jdk 'JDK21'
    }

    // déclaration des stages
    stages {
        // nettoyage du workspace
        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }
        // recopie du depôt dans le workspace
        // option : branch main - url du dépôt - token d'identification
        // dans le compte Github > setting > developper setting > token classic
        // cela permet de créer un token d'authentification valable x jours
        // il faut ensuite le créer dans les crédentials de Jenkins
        stage('Git Checkout') {
            steps {
                // récupération du dépôt GitHub du projet+

                git branch: 'main',
                    credentialsId: 'jenkins_github_PAT',
                    url: 'https://github.com/neojero/webSpringboot2025.git'
            }
        }
        // construction du JAR ou WAR avec maven
        stage('Build Maven') {
            steps {
                // package du projet -Dspring.profiles.active=jenkins
                bat 'mvn clean package'
            }
        }
        // Generation rapport Test
        stage('Generate Allure Report') {
            steps {
                bat 'mvn allure:report'
            }
        }

        // Construction de l'image Docker à partir du Dockerfile
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('neojero/webspringboot2025:latest', '-f Dockerfile .')
                }
            }
        }
        // push de l'image dans le dockerHub
        stage('Push to Docker Hub') {
            steps {
                // il faut également dans le crédentials de Jenkins fournir les infos de connexion
                script {
                    docker.withRegistry('', registryCredential) {
                        docker.image('neojero/webspringboot2025:latest').push()
                    }
                }
            }
        }
        // déploiement du multi containeur avec docker compose
        stage('Deploy with Docker Compose') {
                    steps {
                        // initialise le conteneur docker
                        script {
                            // construit les services
                            bat 'docker-compose up -d --build --force-recreate --remove-orphans'
                        }
                    }
        }
    }
    // aprés réalisation du pipeline, notification du résult sur discord
    post {
        always {
            allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}