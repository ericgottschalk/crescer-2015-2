CREATE TABLE Governadores
(
	ID INT IDENTITY NOT NULL,
	Nome VARCHAR(100) NOT NULL,
	CidadeNatal VARCHAR(100) NOT NULL,
	DataNascimento DATETIME NOT NULL,
	InicioMandato DATETIME NOT NULL,
	FimMandato DATETIME NOT NULL,

	CONSTRAINT PK_GOVERNADORES PRIMARY KEY (ID)
)

-------------------------------------------------

INSERT INTO Governadores (Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
VALUES ('João Carlos de Saldanha Oliveira e Daun', 'Lisboa', CONVERT(DATETIME, '17/11/1790', 103), CONVERT(DATETIME, '22/02/1822', 103), CONVERT(DATETIME, '29/08/1822', 103))

INSERT INTO Governadores (Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
VALUES ('João de Deus Mena Barreto', 'Rio Pardo', CONVERT(DATETIME, '02/07/1769', 103), CONVERT(DATETIME,	'29/08/1822', 103), CONVERT(DATETIME, '29/11/1823', 103))

INSERT INTO Governadores (Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
VALUES ('José Inácio da Silva',	'N/D', CONVERT(DATETIME, '10/01/1791', 103), CONVERT(DATETIME,	'29/11/1823', 103), CONVERT(DATETIME, '08/04/1824', 103))

INSERT INTO Governadores (Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
VALUES ('José Feliciano Fernandes Pinheiro', 'Santos', CONVERT(DATETIME, '09/05/1774', 103), CONVERT(DATETIME, '08/04/1824', 103), CONVERT(DATETIME, '14/01/1826', 103))

INSERT INTO Governadores (Nome, CidadeNatal, DataNascimento, InicioMandato, FimMandato)
VALUES ('José Egídio Gordilho de Barbuda', 'Santos', CONVERT(DATETIME, '09/05/1774', 103), CONVERT(DATETIME, '14/01/1826', 103), CONVERT(DATETIME, '04/11/1826', 103))

------------------------------------------------------------------

SELECT	
	Nome,
	DATEDIFF(YEAR, DataNascimento, InicioMandato) AS [Idade Inicio do Mandato],
	DATEDIFF(MONTH, InicioMandato, FimMandato) AS [Mandato em Meses]
FROM Governadores