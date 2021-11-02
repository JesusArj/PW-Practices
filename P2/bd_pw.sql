CREATE TABLE Usuarios (
  mail varchar(99) NOT NULL,
  password varchar(50) NOT NULL,
  name varchar(99) NOT NULL,
  username varchar(100) NOT NULL,
  PRIMARY KEY (mail),
  CONSTRAINT UC_Usuario UNIQUE (mail,username)
);


CREATE TABLE Criticas (
  id int(6) NOT NULL,  
  puntuacion int(9) NOT NULL, 
  titulo varchar(99) NOT NULL,
  resena varchar(250) NOT NULL, 
  mail varchar(99) NULL,
  PRIMARY KEY (id),
  CONSTRAINT UC_Critica UNIQUE (titulo, id),
  CONSTRAINT fk_Mail FOREIGN KEY (mail) REFERENCES Usuarios (mail)
);

CREATE TABLE VotantesCriticas (
  mail varchar(99) NOT NULL,
  id int(6) NOT NULL,
  voto int(1) NOT NULL, 
  PRIMARY KEY (mail),
  CONSTRAINT UC_VotanteCritica UNIQUE (mail, voto),
  CONSTRAINT fk_MailVC FOREIGN KEY (mail) REFERENCES Usuarios (mail),
  CONSTRAINT fk_idVC FOREIGN KEY (id) REFERENCES Criticas (id)
);

CREATE TABLE EspPuntual (
  id int(9) NOT NULL,   
  titulo varchar(99) NOT NULL,
  descripcion varchar(999) NOT NULL, 
  localidades int(6) NOT NULL,
  localidadesVendidas int(6) NOT NULL, 
  fecha datetime NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT UC_Puntual UNIQUE (id)
);

CREATE TABLE  EspMultiple (
  id int(9) NOT NULL,  
  titulo varchar(99) NOT NULL, 
  descripcion varchar(999) NOT NULL,
  localidades int(6) NOT NULL,
  localidadesVendidas int(6) NOT NULL,  
  PRIMARY KEY (id),
  CONSTRAINT UC_Puntual UNIQUE (id)
);

CREATE TABLE  Fechas (
  fecha datetime NOT NULL, 
  PRIMARY KEY (fecha)
);

CREATE TABLE  MultipleFechas (
  id int(9) NOT NULL,
  fecha datetime NOT NULL, 
  PRIMARY KEY(id, fecha),
  CONSTRAINT fk_idMF FOREIGN KEY (id) REFERENCES EspMultiple (id),
  CONSTRAINT fk_fechasMF FOREIGN KEY (fecha) REFERENCES Fechas (fecha)
);

CREATE TABLE  EspTemporada (
  id int(9) NOT NULL,  
  titulo varchar(99) NOT NULL, 
  descripcion varchar(999) NOT NULL,
  localidades int(6) NOT NULL,
  localidadesVendidas int(6) NOT NULL, 
  PRIMARY KEY (id)
);

CREATE TABLE  Pases (
  pase varchar(99) NOT NULL,
  fechaInicio datetime NOT NULL,
  fechaFinal datetime NOT NULL, 
  PRIMARY KEY (pase)
);

CREATE TABLE  TemporadaPases (
  id int(9) NOT NULL,
  pase datetime NOT NULL, 
  PRIMARY KEY(id, pase),
  CONSTRAINT fk_idTP FOREIGN KEY (id) REFERENCES EspTemporada (id),
  CONSTRAINT fk_paseTP FOREIGN KEY (pase) REFERENCES Pases (pase)
);