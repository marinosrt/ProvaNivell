# ProvaNivell

Es desenvolupa el següent exercici:

Programa de control de facturas. Guardar les dades en fitxers .txt.

Tenim el fitxer "Factura" amb els següents camps: nº factura, nom del client, direcció, telèfon, total factura.
Tenim un altre fitxer "Línies factura", amb els següents camps: nº línia factura, nº factura relacionada, nom de l'article, descripció, quantitat, preu.

Crear menú amb les següents opcions:
1- Crear factura
2- Crear línies de factura a una factura existent
3- Calcular l'import d'una factura
4- Calcular l'import total de totes les factures
5- Mostrar la quantitat de factures d'un client. Si no en té cap, llençar una excepció personalitzada.
6- Mostrar totes les factures d'un client amb l'última data de modificació
7- Mostrar factures d'un client amb una lambda
8- Mostrar les factures que tenen un determinat article amb lambda
9- Eliminar factura d'una forma obsoleta
10- Escriure les factures i les línies de factures en dos fitxers

-----

Tenim
- El menú del programa s'executa a la classe `Main`.
- Classe `menuOptions` amb tots el mètodes del menú.
- Classe `Factura` i `LineasFactura` per a la creació dels objectes.
- Excepció personalitzada `MostrarClientException`.
- Les dues classes `SavingIntoTxtFactura` i `SavingIntoTxtLineaFactura` per a les funcions de creació del fitxer .txt-
