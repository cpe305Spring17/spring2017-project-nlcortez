# Bookkeeping Buddy
[![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-nlcortez.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-nlcortez)
## Description
An Android app used for assisting “micro-business” owners in the bookkeeping process. Bookkeeping Buddy allows sole-proprietors, especially those who make and sell tangible goods over the internet, to log and track their expenses and monitor their inventory. 

## Planned Features 
- Users can create categories for materials 
- Users can create templates for their finished products, allowing for fexibility when determining material costs for each finished product
- Users can specify materials costs and quantities
- Upon adding finished products into “inventory,” material quantities will be adjusted automatically based on each finished product’s respective “materials quantities” and materials costs for that item is calculated automatically 
- Data gathered from the application is used to generate graphs to show expenses, sales, and materials usage
- Data gathered will provide the user with what finished products they can create with their existing supplies 

## System Architecture 
This application uses the Model-View-Presenter architecture pattern. 
![MVP](https://lh3.googleusercontent.com/jYIOMe_zMAf_C01lseQLef6AnAfzwPepPIYB5G4pyAawd0oC9A48pWqYx9SwpvliFUEPIdKU=w1920-h950-rw)

## Class Diagram
![Class Diagram](https://lh4.googleusercontent.com/PaUt42-SETGca0VKT10vcX8VBzG_jSLHKuiExrCEj-mUgtjDSg_0B4b66kIzm8hvuW-L1wVx=w1920-h950-rw)

## Design Patterns 
### Singleton 
The singleton pattern is used for the SQLite database, as only one instance of the database is needed for the application. 

### Observer
The observer pattern is used to allow for safely removing finished products from the finished product inventory. The finished product is the subject, while the materials associated with it are the observers. When a user requests to delete the finished product, the observers are notified and update their "quantity available" field. After this, the finished product can be safely removed from the finished product inventory 

## Screen Captures
![Add Material Category](https://lh3.googleusercontent.com/NqqFp_MFMUz6NLot281JBujZ6LlQ0JrZ2eDR6G7MFbxYevznQ4RZ_zofX3o2B-YaLa-lwKbS=w1920-h950-rw)

![Material Categories](https://lh4.googleusercontent.com/HfaLzDN-fg2uqR8hnAmeKLUl5pM8K-YJBmGC30EjRTTr8T9ilQStevypwdhUhaBKL_haKZN1=w1920-h950-rw)
