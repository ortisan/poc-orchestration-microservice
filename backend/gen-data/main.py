import csv
from faker import Faker
import re
import unidecode

MAX_ROWS = 10000

if __name__ == '__main__':

    fake = Faker(['pt-BR'])

    with open('./data.csv', 'w', newline='') as csvfile:
        fieldnames = ['cpf_cnpj', 'name']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

        writer.writeheader()
        for i in range(1, MAX_ROWS):
            cpf = re.sub(r'\D', '', fake.cpf())
            name = unidecode.unidecode(fake.first_name())
            writer.writerow({'cpf_cnpj': cpf, 'name': name})