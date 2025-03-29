
![VUT logo](https://vizual.vut.cz/images/o5.png)

| mark  | state |
| ------------- | ------------- |
| :white_check_mark:  | done  |
| :pushpin:  | testing needed  |
| :pencil2:  | backend implemented (may include exceptions)  |
| :newspaper:  | frontend impelemented (including checks)  |
| :x:  | not implemented yet  |



| state  | zadani | implemented in |
| ------------- | ------------- | ------------- |
| :pushpin: |  a) Přidávat nové studenty - uživatel vždy provede výběr skupiny, do které chce studenta přiřadit, zadá jeho jméno a příjmení a rok narození. Následně je studentovi přiděleno identifikační číslo odvozené dle celkového pořadí přijímaných studentů. | void setStudent(Integer oborID, String name, String surname, Integer birthDate) |
| :pushpin: |  b) Zadat studentovi novou známku – uživatel vybere studenta podle jeho ID a zadá požadovanou známku. | void setMark(Integer id, Integer mark) |
| :pushpin: |  c) Propuštění studenta z univerzity – uživatel zadá ID studenta, který je odstraněn z databáze. | void Wykonanie(Integer id) |
| :pushpin: |  d) Nalezení jednotlivých studentů dle jejich ID a výpis ostatních informací (jméno, příjmení, rok narození, studijní průměr). | void getStudentInfo(Integer id) |
| :pushpin: |  e) Pro vybraného studenta (dle ID) spustit jeho dovednost (viz rozdělení studentů dle oborů). | void specialAbility(Integer id) |
| :pushpin: |  f) Abecedně řazený výpis všech studentů (dle příjmení) v jednotlivých skupinách (ID, jméno, příjmení, rok narození, studijní průměr). | void getStudentsInInfo(Integer id) |
| :pushpin: |  g) Výpis obecného studijního průměru v obou oborech (společný průměr všech studentů v daném oboru). | double getAvgIn(Integer oborID) |
| :pushpin: |  h) Výpis celkového počtu studentů v jednotlivých skupinách. | Integer getNumberOfStudentsIn(Integer oborID) |
| :x: |  i) Vymazání vybraného studenta ze souboru. | - |
| :x: |  j) Načtení vybraného studenta ze souboru. | - |
| :x: |  k) Při ukončení programu se uloží veškeré informace do SQL databáze. | - |
| :x: |  l) Při spuštění programu se veškeré informace načtou z SQL databáze. | - |