package com.example.losperritos.modelo.aModel.a2Retrofit

/*
Retrofit: c8 m: 50 y c8 m 3:33
Es una Api: Aplicación de interfaz de programación,  se puede definir cómo una biblioteca o librería, de coneccion, nos proporciona una manera de acceder a ciertos servicios, con el fin de utilizarlos o consumirlos
ApiRest = Restfull Api: Funcionan sobre http y https, de forma estandar, en json o xml

El cliente retrofit también(que room) necesita 3 cosas para funcionar

El data clas o pojo: (c8 h 2:13 )aquí convertimos los campos que llegan en json, recordando usar la transformación cuando corresponda, esta transformación usaremos una biblioteca de transformación Gson, la implementación se hace en el gradle // Retrofit     implementation 'com.squareup.retrofit2:converter-gson:2.9.0'. Mas adelante podría usarse Moshi
data class Recibidor (val title:String)
Cliente Retrofit: (c8 h 2:15 )Creo una instancia para usar retrofit “class RetrofitClient{ companion objet {“, el companion objets:es una funcion que se usa para implementar métodos sin instanciar el objeto,el companion objet me devolvera la instancia de cliente retrofit, el va a unificar la interfaz mas los datos que recibira esa interface con este cliente retrofit, la url base se escribe aqui y los end point en el elemento 3
Interfaz de operaciones:(c8 m2:21) “ interface apiclient { “dentro de el se usan @GET y @Headers que son los encabezados, que incluyen el encabezado claves para funcionar, los query params (c8 m2:21) https://square.github.io/retrofit/

 */