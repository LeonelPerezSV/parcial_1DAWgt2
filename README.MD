# Instrucciones para ejecutar el proyecto

GRUPO 10, INTEGRANTES
Franklin Giovanny Avila González; AG22046
Albert Uziel Hernandez Mendoza; HM20019
Leonel Antonio Hernández Pérez; HP12002

Este proyecto utiliza Docker Compose para ejecutar una aplicación Java junto con una base de datos MariaDB. Sigue los pasos a continuación para ejecutar el proyecto de forma correcta.

## Ejecutar el proyecto

1. Clona este repositorio en tu máquina local.

2. Abre una terminal y navega hasta el directorio raíz del proyecto.

3. Elimina las imágenes previamente creadas y borra la caché de Docker antes de ejecutar el Compose. Ejecuta el siguiente comando:

    ```bash
    docker-compose down --rmi all --volumes --remove-orphans && docker-compose up --build
    ```

    Este comando eliminará todas las imágenes previamente creadas, borrará cualquier caché relacionada y luego construirá y ejecutará las imágenes necesarias para el proyecto.

4. Una vez que Docker Compose haya terminado de construir y ejecutar las imágenes, podrás acceder a la aplicación en tu navegador visitando `http://localhost:8080`.

## Comandos adicionales

- Si deseas detener y eliminar los contenedores sin eliminar las imágenes, puedes ejecutar:

    ```bash
    docker-compose down
    ```

- Si deseas detener y eliminar los contenedores, además de eliminar las imágenes, puedes ejecutar:

    ```bash
    docker-compose down --rmi all --volumes --remove-orphans
    ```

- Si deseas detener y eliminar los contenedores pero mantener las imágenes, puedes ejecutar:

    ```bash
    docker-compose down --volumes --remove-orphans
    ```

Recuerda que para ejecutar los comandos de Docker Compose debes tener Docker instalado en tu sistema.

