# person-api
## Heroku:
https://gabrieljuliao-person-api.herokuapp.com/

## Endpoints:

POST /api/v1/person
Accept: application/json
Content-Type: application/json

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "cpf":"123.456.789-10",
  "birthDate": "01-01-1990",
  "phones": [
    {
      "type": "MOBILE",
      "number": "+0000123456789"
    }
  ]
}
```

GET /api/v1/person
Accept: application/json

GET /api/v1/person/{id}
Accept: application/json

PUT /api/v1/person
Accept: application/json
Content-Type: application/json

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "cpf":"123.456.789-10",
  "birthDate": "01-01-1990",
  "phones": [
    {
      "type": "MOBILE",
      "number": "+0000123456789"
    }
  ]
}
```

DELETE /api/v1/person/{id}
Accept: application/json


