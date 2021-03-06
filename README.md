# Work sample instructions

We would like to get an insight into how you solve problems, and how you chose to structure your solutions. To get started, clone this repository (or download the SilverServlet.java file) into a webproject, under the *com.silver* package. From there, extend the servlet (and create additional code files as needed). You may modify the original code as well, as long as the functionality  is preserved. The solution should be exported as an archive (right click the project -> Export -> General -> Archive), and as a .war file (right click the project -> Export -> Web -> War-file), and be sent to us via email.


## Task:
The task is to create a Java server which can manage a shopping list. The server should be a Tomcat 8 server, which can handle GET requests. In case parameter needs to be passed to an endpoint, they should be passed as query parameters. All responses should be in JSON format, and should follow the response format listed bellow.

The user should be able to: 
* add items to her shopping list. If one of the item is not in the list of valid items, the user should receive an error message and none of the items in the request should be added.
* check her current shopping list. The shopping list should be sorted after the number of items, from the least to the most.
* clear her shopping list.
* request which items that can be bought, and what their price are. The items list should be sorted alphabetically (A -> Z).


## Endpoint response format, and flow example:

    GET: /prices
      ->
      {
        "status": 1,
        "data": {
          "items": [
            {
              "item": "apple",
              "price": 1
            },
            {
              "item": "banana",
              "price": 1
            },
            {
              "item": "butter",
              "price": 11
            },
            {
              "item": "egg",
              "price": 1
            },
            {
              "item": "flour",
              "price": 2
            },
            {
              "item": "milk",
              "price": 5
            }
          ]
        }
      }

    GET: /add?items=flour,egg,egg,apple,milk
      ->
      {
        "status": 1,
        "data": true
      }

    GET: /list
      ->
      {
        "status": 1,
        "data": {
          "items": [
            "milk": 1,
            "flour": 1,
            "apple": 1,
            "egg": 2
          ]
        }
      }

    GET: /add?items=flour,flour,egg
      ->
      {
        "status": 1,
        "data": true
      }

    GET: /list
      ->
      {
        "status": 1,
        "data": {
          "items": [
            "milk": 1,
            "apple": 1,
            "flour": 3,
            "egg": 3
          ]
        }
      }

    GET: /add?items=raddish,egg
      ->
      {
        "status": 17,
        "error": "Invalid item type"
      }

    GET: /list
      ->
      {
        "status": 1,
        "data": {
          "items": [
            "milk": 1,
            "egg": 1,
            "apple": 3,
            "flour": 3
          ]
        }
      }

    GET: /clear
      ->
      {
        "status": 1,
        "data": true
      }

    GET: /list
      ->
      {
        "status": 1,
        "data": {
          "items": [
          ]
        }
      }
