set search_path to medical;

-- Написать запрос, удаляющий повторяющиеся (без учета id) в таблице (address)
delete
from address as a1 using address as a2
where a1.id > a2.id
  and a1.contact_id = a2.contact_id
  and a1.country_id = a2.country_id
  and a1.city = a2.city
  and a1.index = a2.index
  and a1.street = a2.street
  and a1.buildings = a2.buildings
  and a1.flat = a2.flat
