set search_path to medical;

create table if not exists medical_card
(
    id            bigserial not null,
    client_status char      not null,
    med_status    char,
    registry_dt   date      not null,
    comment       text,
    primary key (id)
);

create table if not exists contact
(
    id           bigserial    not null,
    phone_number varchar(32)  not null,
    email        varchar(128) not null,
    profile_link text,
    primary key (id)
);

create table if not exists illness
(
    id              bigserial not null,
    medical_card_id bigserial not null,
    type_id         bigserial not null,
    heaviness       char      not null,
    appearance_dttm timestamp not null,
    recovery_dt     date      not null,
    primary key (id),
    foreign key (medical_card_id) references medical_card (id)
);

create table if not exists address
(
    id         bigserial    not null,
    contact_id bigserial    not null,
    country_id bigserial    not null,
    city       varchar(255) not null,
    index      integer      not null,
    street     varchar(255) not null,
    buildings  varchar(32)  not null,
    flat       varchar(32)  not null,
    primary key (id),
    foreign key (contact_id) references contact (id)
);

create table if not exists person_data
(
    id              bigserial    not null,
    last_name       varchar(255) not null,
    first_name      varchar(255) not null,
    birth_dt        date         not null,
    age             smallint     not null,
    sex             char         not null,
    contact_id      bigserial    not null,
    medical_card_id bigserial    not null,
    parent_id       bigint,
    primary key (id),
    foreign key (contact_id) references contact (id),
    foreign key (medical_card_id) references medical_card (id),
    foreign key (parent_id) references person_data (id),
    check ( parent_id <> id )
);