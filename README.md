# Ejercicio PSP 2025-26 -> Centro de copias de la biblioteca

## Contexto
En una biblioteca hay un centro de copias utilizado por estudiantes.
  - Hay 5 estudiantes que quieren hacer copias de sus apuntes.
  - El centro dispone de 2 máquinas de copiado.
  - Cada máquina solo puede ser usada por un estudiante a la vez.
  - Los estudiantes trabajan de forma simultánea y deben esperar si no hay máquinas
libres.

## Objetivo del proyecto
Simular en Java el funcionamiento del centro de copias usando programación
concurrente, garantizando:
  - Uso correcto de hilos
  - Exclusión mutua
  - Coordinación entre hilos con synchronized
  - Espera y notificación (wait() / notify())

## Enunciado:
Existen 5 estudiantes, cada uno representado por un hilo.
Cada estudiante repite el siguiente ciclo:
1. Estudia (espera un tiempo aleatorio)
2. Va al centro de copias
3. Solicita una máquina
4. Hace las copias
5. Libera la máquina y vuelve a estudiar

## Requisitos técnicos
Hilos
  - Cada estudiante debe ser un hilo (Runnable o Thread).
  - Deben existir exactamente 5 estudiantes.
    
Recursos compartidos
  - Existen 2 máquinas de copiado.
  - Cada máquina solo puede ser usada por un estudiante a la vez.

Sincronización (obligatoria)
  - La gestión de las máquinas debe hacerse en una clase central (por ejemplo
CentroCopias).
  - El acceso debe estar protegido con synchronized.

Cuando no haya máquinas libres:
  - El estudiante debe esperar (wait()).

Cuando una máquina se libere:
  - Se debe notificar a los estudiantes en espera (notify() o notifyAll()).

Control correcto de la espera
  - No puede haber esperas activas (while(true) sin wait()).
  - El acceso debe estar correctamente controlado para evitar:
    - Dos estudiantes usando la misma máquina
    - Errores de sincronización

## Salida por consola
Debe verse claramente qué ocurre en el sistema:
  - EJ: "Estudiante 2 está estudiando
  
    Estudiante 2 solicita máquina
  
    Estudiante 2 usa máquina 1
  
    Estudiante 2 termina y libera máquina 1"

## Control de ejecución
- El programa se ejecutará durante 20 segundos.
- Al finalizar:
  - Todos los hilos deben finalizar correctamente
  - Se mostrará cuántas veces hizo copias cada estudiante
