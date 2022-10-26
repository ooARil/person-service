set search_path to medical;

-- Написать запрос, выводящий список ФС с их родителями,
-- у которых мед статус отсутствует
select *
from person_data as p
where p.id in (select id
               from medical_card as mc
               where mc.med_status is null)