CREATE PROCEDURE add_num0(in a int, in b int)
begin
    select a + b;
end;

CREATE PROCEDURE add_num1(in a int, in b int, out c int)
begin
    select
        a + b
    into c;
end;

CREATE PROCEDURE add_num2(in a int, in b int, out c int)
begin
    declare
        r int;
    select
        a + b
    into r;
    select
        r
    into c;
end;

CREATE PROCEDURE add_num3(in a int, in b int, out c int)
begin
    declare
        r int;
    set
        r = a + b;
    set
        c = r;
end;

CREATE PROCEDURE check_score(in score int, out msg varchar(255))
begin
    if
        score >= 90 then
        set msg := 'A';
    elseif
        score >= 80 then
        set msg := 'B';
    elseif
        score >= 70 then
        set msg := 'C';
    elseif
        score >= 60 then
        set msg := 'D';
    else
        set msg := 'F';
    end if;
end;

CREATE PROCEDURE hello_world()
begin
    select 'Hello World!';
end;

CREATE PROCEDURE sum_1_to_100(out res int)
begin
    declare
        i int default 1;
    set
        res := 0;
    while
        i <= 100
        do
            set res := res + i;
            set
                i := i + 1;
        end while;
end;
