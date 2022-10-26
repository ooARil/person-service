set search_path to medical;

-- Написать запрос, выводящий общие записи из 2 таблицы (medical_card и illness)
select *
from medical_card as mc
         inner join illness as i
                    on mc.id = i.medical_card_id