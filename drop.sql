
    set client_min_messages = WARNING;

    alter table if exists alimentazione_tipo_veicolo 
       drop constraint if exists FK5fk8b2jheou7sgaywj91i6tfh;

    alter table if exists alimentazione_tipo_veicolo 
       drop constraint if exists FKpcf7h8lsonsihtkekf9nrr5pf;

    alter table if exists bici 
       drop constraint if exists FKbws1i3mir17a05465g0hcpq2b;

    alter table if exists bici 
       drop constraint if exists FK5w8050dk24bill0p1oybx526d;

    alter table if exists bici 
       drop constraint if exists FKi5oid68i9rxxblvmtn9m2o23h;

    alter table if exists categoria_tipo_veicolo 
       drop constraint if exists FK4qphatkdao1ybsbj3rj1je3xe;

    alter table if exists categoria_tipo_veicolo 
       drop constraint if exists FKl9tpa4n16jptbe2r32wkydpqd;

    alter table if exists macchina 
       drop constraint if exists FKoelgn029d5si9n8nlgjai441m;

    alter table if exists moto 
       drop constraint if exists FK8bspqpxxs5e6umxpiktmxolv0;

    alter table if exists veicolo 
       drop constraint if exists FK2vsaxu42kao1fd973kjeegsud;

    alter table if exists veicolo 
       drop constraint if exists FK1ffq24yvhb1147soqdmhcrr75;

    alter table if exists veicolo 
       drop constraint if exists FKc2pjr19k42ngy56jq4xo1h246;

    drop table if exists alimentazione cascade;

    drop table if exists alimentazione_tipo_veicolo cascade;

    drop table if exists bici cascade;

    drop table if exists categoria cascade;

    drop table if exists categoria_tipo_veicolo cascade;

    drop table if exists freno cascade;

    drop table if exists macchina cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists moto cascade;

    drop table if exists sospensione cascade;

    drop table if exists tipo_veicolo cascade;

    drop table if exists veicolo cascade;
