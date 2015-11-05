ALTER TABLE Jogo
ADD
	[IdSelo] INT NULL,
	[Desscricao] VARCHAR(MAX) NULL,
	[Imagem] VARCHAR(500) NULL,
	[Video] VARCHAR(500) NULL


ALTER TABLE Jogo 
ADD
	CONSTRAINT FK_Jogo_Selo FOREIGN KEY (IdSelo) REFERENCES Selo(Id)

UPDATE Jogo
SET IdSelo = 1
WHERE Preco > 100

UPDATE Jogo
SET IdSelo = 2
WHERE Preco >= 40 AND Preco < 100

UPDATE Jogo
SET IdSelo = 3
WHERE Preco < 40

ALTER TABLE Jogo
ALTER COLUMN 
	[IdSelo] INT NOT NULL	
