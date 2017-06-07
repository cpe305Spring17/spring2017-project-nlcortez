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
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/MVP.png?raw=true">

## Class Diagram
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/ClassDiagram2.png?raw=true">

## Design Patterns 
### Singleton 
The singleton pattern is used for the SQLite database, as only one instance of the database is needed for the application. 

### Observer
The observer pattern is used to allow for safely removing finished products from the finished product inventory. The finished product is the subject, while the materials associated with it are the observers. When a user requests to delete the finished product, the observers are notified and update their "quantity available" field. After this, the finished product can be safely removed from the finished product inventory.

### Command
Callbacks are used in the DialogFragments so that information inputted into each respective dialog can be  sent back to the presenter. 

### Adapter
Adapters are used to populate drop down menus (spinners) and RecyclerViews.


## Screen Captures
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/Overview.png?raw=true" width="480">

<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/MaterialCategories.png?raw=true" width="480"> 
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/AddMaterialCategory2.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/MaterialTemplate.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/AddMaterialTemplate.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/Materials.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/AddMaterial.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/UpdateMaterial.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/ProductTemplates.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/AddProductTemplate.png?raw=true" width="480">
<img src="https://github.com/cpe305Spring17/spring2017-project-nlcortez/blob/gh-pages/Screenshots/AddProductTemplate2.png?raw=true" width="480">
