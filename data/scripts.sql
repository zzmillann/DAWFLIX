CREATE TABLE IF NOT EXISTS juegos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT UNIQUE NOT NULL,
    descripcion TEXT,
    duracion REAL,
    genero TEXT,
    plataforma TEXT,
    multijugador INTEGER -- 0 = false, 1 = true
);


CREATE TABLE IF NOT EXISTS series (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT UNIQUE NOT NULL,
    descripcion TEXT,
    duracion REAL,
    genero TEXT,
    temporadas INTEGER,
    capitulos INTEGER
);



CREATE TABLE IF NOT EXISTS peliculas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT UNIQUE NOT NULL,
    descripcion TEXT,
    duracion REAL,
    genero TEXT,
    director TEXT,
    estreno INTEGER -- año de estreno
);





CREATE TABLE usuarios (
    nombre TEXT NOT NULL,
    email TEXT PRIMARY KEY,
    tipo_suscripcion TEXT NOT NULL,
    precio_suscripcion REAL NOT NULL,
    favoritos TEXT,
    estoy_viendo TEXT
);



CREATE TABLE reproducciones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    email_usuario TEXT NOT NULL,
    titulo_contenido TEXT NOT NULL,
    fecha_reproduccion DATETIME DEFAULT CURRENT_TIMESTAMP
);