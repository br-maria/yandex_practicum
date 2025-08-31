# Этап сборки
FROM openjdk:24-slim AS builder

# Установка Maven
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://archive.apache.org/dist/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz && \
    tar -xzf apache-maven-3.9.1-bin.tar.gz && \
    mv apache-maven-3.9.1 /usr/share/maven && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Настройка переменных окружения
ENV MAVEN_HOME=/usr/share/maven
ENV MAVEN_CONFIG=/root/.m2
ENV PATH=$MAVEN_HOME/bin:$PATH

# Установка версии Java
ENV JAVA_VERSION=24
ENV MAVEN_COMPILER_TARGET=24
ENV MAVEN_COMPILER_SOURCE=24

WORKDIR /app

# Копируем pom.xml
COPY pom.xml .

# Копируем исходный код
COPY src/ ./src/

# Устанавливаем зависимости и собираем проект
RUN mvn clean package -DskipTests \
    -Dmaven.compiler.target=$MAVEN_COMPILER_TARGET \
    -Dmaven.compiler.source=$MAVEN_COMPILER_SOURCE

# Этап выполнения
FROM openjdk:24-slim

WORKDIR /app

# Копируем jar-файл
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]

# Дополнительные настройки
ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF8 -Duser.timezone=UTC"
ENV SPRING_OUTPUT_ANSI_ENABLED=always
ENV JAVA_OPTS="-Xmx512m -Xms256m"
