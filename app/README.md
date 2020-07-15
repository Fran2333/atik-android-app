### AtikApp

En este apartado se explica el proyecto de frontend para la aplicacion movil AtikApp, desarrollado por los componentes de Android Studio
y el lenguaje de programacion Kotlin.

### Run Project

Los pasos a seguir para la compilacion del proyecto son:
- Levantar Atik api (instrucciones se encuentran en el submodulo de Atik api)
- Lo necesario es descargar este repositorio para luego ser abierto desde Android Studio. Una vez abierto el proyecto en Android Studio, si llegase
a dar un problema de compilacion, asegurarse  que su version de Android Studio este a partir de 4.0 y si no esta en esa version actualizar y
limpiar el proyecto para evitar problemas de compilacion ya que hemos ocupado implementaciones recientes.
- Como siguiente paso es correr la aplicacion en cualquier dispositivo ya que esta adaptado desde el movil mas pequeno hasta el mas grande, tomando
en cuenta tablets

### Inicio de sesion

- La primera pantalla a mostrar es la de login,para hacer uso de la aplicacion tenemos 2 tipos de usuarios:

1. usuario administrador: este es el que se encarga de administrar los procesos de la aplicacion, y este es el unico que puede acceder a estos
atributos el inicio de sesión se hacen con admin@admin.com con contraseña administrador.

2. usuario cliente: este es el que hace uso principal de la aplicacion, a el se le restringuen los privilegios del administrador. Para este tipo
de usuario se puede acceder desde  el de cliente es cliente@cliente.com con contraseña cliente