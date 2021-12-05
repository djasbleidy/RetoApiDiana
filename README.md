# Prueba Diana Castaño

Este proyecto contiene Reto de automatización el cual contiene escenarios y casos de pruebas en formato BDD.

## Contexto del desarrollo

Se realiza la automatización de la ubicación de una persona o de un lugar de interés para mostrar la ubicación en cualquier punto de la superficie terrestre.

Se aplico un escenario exitoso donde nos mostrara el sitio con la hora actual de los lugares: Angola, Guatemala, Montería y Bogota
Y dos escenario donde se validara valores nulos o campos no existentes donde mostrara el error en la consulta

## Installation

Ingresamos el siguiente comando par clonar el repositorio:

```bash
 git clone git@github.com:djasbleidy/RetoApiDiana.git
```
ingresamos al proyecto

```bash
 cd Api-base-test
```


## Usage

```python

# borra antiguas ejecuciones
gradle clean

# ejecuta los test
gradle test

# genera el reporte 
gradle aggregate

# si desea ejecutar todos las acciones en un comando
gradle clean test aggregate
```

## Ruta Reporte

/target/site/serenity/index.html
