# API de E-commerce y Clima

  

Una API desarrollada en **Java** con **Spring Boot**, que permite realizar operaciones CRUD sobre productos almacenados en una base de datos **MongoDB** y consultar el clima mediante una API externa. La API está documentada utilizando **Swagger**.

  

---

  

## 🚀 Funcionalidades

  

- **Gestión de Productos:**

Realiza operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos.

  

- **Consulta del Clima:**

Obtiene información meteorológica actualizada a través de una API externa.

  

---

  

## 🛠 Requisitos

  

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

  

1. **Docker:** Tener [Docker](https://www.docker.com/) instalado en tu sistema.

2. **Código del Proyecto:**

- **Opción 1:** Clonar este repositorio usando el comando:

```bash

	git clone https://github.com/JuanPabloOrtizJaimes/apiEcommerce.git

```

- **Opción 2:** Descargar el archivo ZIP del proyecto y descomprimirlo.

  

---

  

## 🏃‍♂️ Pasos para Ejecutar

  

1. Navega a la carpeta del proyecto.

```bash

	cd apiEcommerce-main

  ```

2. Ejecuta los siguientes comandos en la terminal:

- Construir los contenedores:

```bash

	docker compose build

```

- Levantar los servicios:

```bash

	docker compose up

```

3. Accede a la interfaz de Swagger para explorar y probar la API:

	[Swagger UI](http://localhost:8081/api/v1/swagger-ui/index.html)

  

---
## ✍️ Consideraciones a tener en cuenta

  

- **Version de Docker Probada:** 27.4.1.  
- **Problemas con AVX mongodb:** Si tu procesador no soporta AVX cambia la version de Mongo en el docker-compose.yml a mongo:4.4.
  

## 🧑‍💻 Tecnologías Utilizadas

  

- **Java:** Lenguaje principal del proyecto.  
- **Spring Boot:** Framework para el desarrollo rápido y robusto de aplicaciones web.  
- **MongoDB:** Base de datos NoSQL utilizada para almacenar los productos.  
- **Docker:** Para la virtualización y despliegue de contenedores.  
- **Swagger:** Documentación interactiva para APIs.  
- **APIs Externas:** Consumo de servicios meteorológicos.

  

---

  

## 📚 Estructura del Proyecto

```
/apiEcommerce
├── src/                # Código fuente principal
│   ├── main/           # Código de la aplicación
│   └── test/           # Pruebas unitarias
├── docker-compose.yml  # Configuración de Docker Compose
├── Dockerfile          # Instrucciones para construir la imagen de Docker
├── pom.xml             # Dependencias y configuración de Maven
├── README.md           # Documentación del proyecto
└── ...                 # Otros archivos del proyecto
```

---
## 👥 Autor

- [Juan Pablo](https://github.com/JuanPabloOrtizJaimes)

