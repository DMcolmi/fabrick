# Fabrick
## assignment notes by Davide Maria Colmi

Gestione eccezioni:
1) FabrickRestException: eccezione specifica per errori durante la comunicazione con le API di Fablick
2) RestExceptionHandler: in caso di errore durante la comunicazione con Fablick applica uno specifico HttpStatusCode e message

Logging:
1) viene utilizzato logback. file di configurazione in resources. log su FILE e CONSOLE, settato su livello INFO, modificabile a seconda della necessità in DEBUG
2) all'interno delle classi, tramite LoggerFactory è creata un istanza del logger. sono loggate le operazioni principali dell'applicativo con livello DEBUG, gli errori con livello ERROR

Comunicazione con API esposte da Fabrick:
1) configurazione WebClient gestita dalla classe FabrickWebClientConfig
2) API consumate nella classe FabrickApiService

Controller REST:
- BanckingAccountController espone le seguenti API. base URL: /api/bancking-account

1)	"/api/bancking-account/"
	-	Query Params: accountId
	-	Restituisce: dettagli account:
		{
		    "accountId": "14537780",
		    "iban": "IT40L0326822311052923800661",
		    "abiCode": "03268",
		    "cabCode": "22311",
		    "countryCode": "IT",
		    "internationalCin": "40",
		    "nationalCin": "L",
		    "account": "52923800661",
		    "alias": "Test api",
		    "productName": "Conto Websella",
		    "holderName": "LUCA TERRIBILE",
		    "activatedDate": "2016-12-14",
		    "currency": "EUR"
		}
	-	esempio chiamata: http://localhost:8080/api/bancking-account/?accountId=14537780

2)	"/api/bancking-account/account-balance"
	-	Query Params: accountId
	-	Restituisce: Lettura saldo account:
		{
		    "date": "2023-07-22T00:00:00.000+00:00",
		    "balance": 999995.12,
		    "availableBalance": 999987.94,
		    "currency": "EUR"
		}
	-	esempio chiamata: http://localhost:8080/api/bancking-account/account-balance?accountId=14537780

3)	"/api/bancking-account/account-transactions"
	-	Query Params: accountId, fromDate, toDate
	-	Restituisce: Lista di transazioni account:
		{
		    "list": [
		        {
		            "transactionId": "519157",
		            "operationId": "00000000519157",
		            "accountingDate": "2019-12-31T00:00:00.000+00:00",
		            "valueDate": "2020-01-01",
		            "type": {
		                "enumeration": "GBS_TRANSACTION_TYPE",
		                "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
		            },
		            "amount": -586,
		            "currency": "EUR",
		            "description": "PD VISA CORPORATE 11"
		        }
		    ]
		}
	-	esempio chiamata: http://localhost:8080/api/bancking-account/account-transactions?accountId=14537780&fromDate=2019-01-01&toDate=2019-12-01
	



