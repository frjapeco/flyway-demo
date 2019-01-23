CREATE TABLE [${schema}].[customer] (
  id INT NOT NULL,
  name VARCHAR(255) NOT NULL
);

INSERT INTO [${schema}].[customer] (id, name) VALUES (1,'Paco'), (2,'Pepe'), (3, 'Manolo');