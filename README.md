Controller REST:
-BanckingAccountController espone le seguenti API. base URL: /api/bancking-account

1)	"/api/bancking-account/"
	-	Query Params: accountId
	-	Restituisce: dettagli account
	-	esempio chiamata: http://localhost:8080/api/bancking-account/?accountId=14537780

2)	"/api/bancking-account/account-balance"
	-	Query Params: accountId
	-	Restituisce dettagli account balance
	-	esempio chiamata: http://localhost:8080/api/bancking-account/account-balance?accountId=14537780

3)	"/api/bancking-account/account-transactions"
	-	Query Params: accountId, fromDate, toDate
	-	Restituisce dettagli account transactions
	-	esempio chiamata: http://localhost:8080/api/bancking-account/account-transactions?accountId=14537780&fromDate=2019-01-01&toDate=2019-12-01

Gestione eccezioni:
1) FabrickRestException: eccezione specifica per errori durante la comunicazione con le API di Fablick
2) RestExceptionHandler: in caso di errore durante la comunicazione con Fablick applica uno specifico HttpStatusCode e message

Logging:
1) viene utilizzato logback. file di configurazione in resources. log su FILE e CONSOLE, settato su livello INFO, modificabile a seconda della necessità in DEBUG
2) all'interno delle classi, tramite LoggerFactory è creata un istanza del logger. sono loggate le operazioni principali dell'applicativo con livello DEBUG, gli errori con livello ERROR
