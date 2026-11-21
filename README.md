# TP3 - Calculatrice REST

Gharbi Youssef - LSI3 - Architecture SOA et services web.

Le service réalise une addition, une soustraction, une multiplication et une division. Les appels utilisent GET et les réponses sont en JSON.

## Outils

Java 17 ou supérieur, Maven, Jakarta REST 3.1.0, Jersey 3.1.4 et Tomcat 10.1.

## Exécution

Depuis le dossier du projet :

```powershell
mvn clean package
```

Copier `target/CalculatriceREST.war` dans le dossier `webapps` de Tomcat, puis démarrer Tomcat.

Pour retrouver les adresses des captures, configurer le connecteur HTTP dans `conf/server.xml` de Tomcat sur le port **8081**. Ce port a été utilisé car le serveur SOAP du TP2 occupait le port 8080. Si Tomcat utilise un autre port, adapter les URL dans Postman.

## Tests Postman

Importer le fichier `CalculatriceREST.postman_collection.json` avec **Import > Files**. Sélectionner ce fichier uniquement.

Base des URL : `http://localhost:8081/CalculatriceREST/api/calcul/`

| Opération | Paramètres | Résultat |
|---|---|---|
| addition | a=10, b=5 | 15.0 |
| soustraction | a=10, b=5 | 5.0 |
| multiplication | a=10, b=5 | 50.0 |
| division | a=10, b=5 | 2.0 |

Exemple : `http://localhost:8081/CalculatriceREST/api/calcul/addition?a=10&b=5`.

Les quatre opérations ont été vérifiées par HTTP avec le statut 200. Les captures Postman sont dans `captures/` et dans le rapport PDF. La capture d’addition montre aussi le statut 200 ; les trois autres sont centrées sur le JSON. La division par zéro renvoie 400.

Les assertions de la collection vérifient le statut et le JSON ; leur exécution dans Postman n’est pas attestée par les captures.

## Rapport

`Rapport_TP3_SOA_Gharbi_Youssef.pdf` contient les étapes, l’environnement technique, le schéma REST et les quatre captures.

Dépôt : https://github.com/gharyba/TP3-SOA2026
