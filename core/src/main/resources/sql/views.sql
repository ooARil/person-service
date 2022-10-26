set search_path to medical;

-- Объединил информацию с таблиц person_data, medical_card и illness
create view person_medical_card as
select mc.id,
       pd.last_name,
       pd.first_name,
       pd.sex,
       pd.birth_dt,
       mc.med_status,
       mc.registry_dt,
       mc.comment,
       i.type_id,
       i.heaviness
from medical_card as mc
join person_data as pd on mc.id = pd.medical_card_id
join illness as i on mc.id = i.medical_card_id
order by mc.id