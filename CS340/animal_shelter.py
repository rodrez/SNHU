import pymongo

MongoClient = pymongo.MongoClient


class Connection(object):
    """ CRUD operations for collections in MongoDB """

    def __init__(self,
                 username='aacuser',
                 password='0925',
                 port="29729",
                 host="localhost",
                 db_name="AAC",
                 auth_source="AAC"
                 ):
        # Initializing the MongoClient. This helps to
        # access the MongoDB databases and collections.

        self.username = username
        self.password = password
        self.port = port
        self.host = host
        self.db_name = db_name
        self.auth_source = auth_source
        self.client = MongoClient(
            f'mongodb://{self.username}:{self.password}@{self.host}:{self.port}/{self.db_name}?authSource={self.auth_source}')

        # Test the connection
        self.test_connection()

    def test_connection(self):
        try:
            self.client.server_info()
            print("Connected to MongoDB")
        except Exception as e:
            print(f'Error: {e}')

    def get_db(self):
        """ Connect to MongoDB """
        # Return the database
        return self.client[str(self.db_name)]

    def get_collection(self,
                       name: str) -> pymongo.collection.Collection or Exception:
        """ Get a collection by name
            Parameters# A docstring.

            ----------
            name : str
                The name of the collection to be retrieved.

            Returns
            -------
            pymongo.collection.Collection
                Collection with the specified name.

            Raises
            ------
            Exception
                If an error occurs during the retrieval of the collection.
         """

        try:
            database = self.get_db()
            collection = database[name]
            return collection
        except Exception as e:
            print(f'Error: {e}')
            return e

    def create(self, query: dict, collection_name: str) -> bool:
        """ Create a new animal in the database

        Parameters
        ----------
        data : dict
            Dictionary containing the animal data to search for
        collection : str
            Name of the collection
        new_data : dict
            Dictionary containing the updated animal data

        Returns
        -------
        bool
            True if the animal was updated, False if not

        """
        collection = self.get_collection(collection_name)
        try:
            if type(query) is dict:
                collection.insert_one(query)
                return True
            else:
                return False
        except Exception as e:
            print(f'Error: {e}')
            return False

    def read(self, query: dict,
             collection_name: str = 'animals') -> pymongo.cursor.Cursor or dict:
        """ Read an animal from the database

            Parameters
            ----------
            data : dict
                Dictionary containing the animal data
            collection : str
                Name of the collection to read from

            Returns
            -------
            cursor : pymongo.cursor.Cursor
                Cursor object containing the result of the query

            Raises
            ------
            Exception
                Raised when `data` is None or not a dictionary.
                :param collection_name:
        """

        collection = self.get_collection(collection_name)

        # Ensure data is not empty and is a dictionary
        if query is not None and type(query) is dict:
            # Return the result of the find query
            try:
                query.update({"_id": 0})
                return collection.find(query)
            except Exception as e:
                return {"error": str(e)}

        elif query is None:
            return {"error": "Nothing to save, because data parameter is empty"}
        else:
            return {"error": "Data parameter is not a dictionary"}

    def update(self, search_filter: dict, query: dict,
               collection_name: str) -> dict:
        """
        Update animal information in the database.

        Parameters
        ----------
        search_filter : dict
            Dictionary containing the search criteria for the document(s) to be updated.
        data : dict
            Dictionary containing the updated data for the document(s).
        collection : str
            Name of the collection in which the document(s) reside.

        Returns
        -------
        dict
            Result in JSON format if successful, else MongoDB returned error message.

         """
        collection = self.get_collection(collection_name)
        try:
            if type(search_filter) is dict and type(query) is dict:
                result = collection.update_many(search_filter, {"$set": query})
                if result.modified_count:
                    return {"result": "Data updated successfully"}
                else:
                    return {"result": "No data was updated"}
        except Exception as e:
            return {"error": str(e)}

    def delete(self, collection_name: str, query: dict) -> dict:
        """
        Delete documents from a specified MongoDB database and collection

        Parameters
        ----------
        collection_name : str
            Name of the collection
        query : dict
            Key/value lookup pair to use with the MongoDB driver find API call

        Returns
        -------
        dict
            Result in JSON format if successful, else MongoDB returned error message

        """
        try:
            collection = self.get_collection(collection_name)
            result = collection.delete_many(query)
            return {'deleted_count': result.deleted_count}
        except Exception as e:
            return {'error': str(e)}

        ################


# TESTS
################

# Test create function
def test_create():
    print("Testing create function")
    c = Connection()
    data = {
        "name": "test",
        "age": 1,
        "type": "test"
    }
    assert c.create(data, "animals") is True
    print("Test complete")


# Test read function
def test_read(connecton):
    print("Testing read function")
    c = Connection()
    data = {
        "name": "test",
        "age": 1,
        "type": "test"
    }
    assert c.read(data, "animals") is not None
    print("Test complete")


# Test update function
def test_update():
    print("Testing update function")
    c = Connection()
    search_filter = {
        "name": "test",
        "age": 1,
        "type": "test"
    }
    new_data = {
        "name": "test",
        "age": 2,
        "type": "test"
    }
    assert c.update(search_filter, new_data, "animals") is not None
    print("Test complete")


# Test delete function
def test_delete():
    print("Testing delete function")
    c = Connection()
    data = {
        "name": "test",
        "age": 2,
        "type": "test"
    }
    assert c.delete_documents("animals", data) is not None
    print("Test complete")


AnimalShelter = Connection
