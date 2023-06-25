from mango import AnimalShelter


shelter = AnimalShelter(port="27017", username="user", password="password", host="localhost", db_name="project")


if __name__ == '__main__':
    shelter.test_connection()

    shelter.create()