# WE :cupid: JAVA:exclamation::boom::fire:
<details>
  <summary>for real</summary>
   :trollface:
</details>

![VUT logo](https://vizual.vut.cz/images/o5.png)

## Meanings of marks
| mark  | state |
| ------------- | ------------- |
| :white_check_mark:  | done  |
| :pushpin:  | testing needed  |
| :pencil2:  | backend implemented (does not include exceptions, may include checks)  |
| :newspaper:  | frontend impelemented  |
| :x:  | not implemented yet  |

## States of implementing required features

| state  | zadani | implemented in | checkes | exceptions |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| :newspaper: |  a) Přidávat nové studenty - uživatel vždy provede výběr skupiny, do které chce studenta přiřadit, zadá jeho jméno a příjmení a rok narození. Následně je studentovi přiděleno identifikační číslo odvozené dle celkového pořadí přijímaných studentů. | void setStudent(Integer oborID, String name, String surname, Integer birthDate) | :pushpin: (OborID, BirthDate) | :x: |
| :newspaper: |  b) Zadat studentovi novou známku – uživatel vybere studenta podle jeho ID a zadá požadovanou známku. | boolean setMark(Integer id, Integer mark) | :pushpin: (1-5) | :x: |
| :newspaper: |  c) Propuštění studenta z univerzity – uživatel zadá ID studenta, který je odstraněn z databáze. | void Wykonanie(Integer id) | :pushpin: | :x: |
| :newspaper: |  d) Nalezení jednotlivých studentů dle jejich ID a výpis ostatních informací (jméno, příjmení, rok narození, studijní průměr). | void getStudentInfo(Integer id) |  :pushpin: | :x: |
| :newspaper: |  e) Pro vybraného studenta (dle ID) spustit jeho dovednost (viz rozdělení studentů dle oborů). | void specialAbility(Integer id) | :pushpin: | :x: |
| :newspaper: |  f) Abecedně řazený výpis všech studentů (dle příjmení) v jednotlivých skupinách (ID, jméno, příjmení, rok narození, studijní průměr). | void getStudentsInInfo(Integer id) | :heavy_check_mark: kod oboru 1/2) | :x: |
| :newspaper: |  g) Výpis obecného studijního průměru v obou oborech (společný průměr všech studentů v daném oboru). | double getAvgIn(Integer oborID) | :pushpin: | :x: |
| :newspaper: |  h) Výpis celkového počtu studentů v jednotlivých skupinách. | Integer getNumberOfStudentsIn(Integer oborID) | :pushpin: | :x: |
| :x: |  i) Vymazání vybraného studenta ze souboru. | - | - | - |
| :x: |  j) Načtení vybraného studenta ze souboru. | - | - | - |
| :x: |  k) Při ukončení programu se uloží veškeré informace do SQL databáze. | - | - | - |
| :x: |  l) Při spuštění programu se veškeré informace načtou z SQL databáze. | - | - | - |

### Banger na konec :clapper: :musical_note:
:link: https://www.youtube.com/watch?v=yup8gIXxWDU
[![Watch the video](https://img.youtube.com/vi/yup8gIXxWDU/hqdefault.jpg)](https://youtu.be/yup8gIXxWDU)