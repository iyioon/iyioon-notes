# Unix CLI 

## SSH Login to SOC Unix Account

```shell
ssh jhmoon@stu.comp.nus.edu.sg
ssh jhmoon@sunfire-r.comp.nus.edu.sg
```

## Transfer File and Download

```shell
scp -r /Users/jason/Documents/NUS/Module/CS2030/Lab5 jhmoon@stu.comp.nus.edu.sg:/home/j/jhmoon

scp -r jhmoon@stu.comp.nus.edu.sg:/home/j/jhmoon/Lab5 /Users/jason/Documents/NUS/Module/CS2030
```

## Command
- `mkdir` make directory
- `rmdir` remove directory
- `rm -r` force remove directory
- `cd ~` go to user directory
- `mv` move
- `cp -i ../lab4/*.java` copy all java file to the current dir

## JAVA

``` shell
bash .∕test.sh Lab0
```

```shell
java Main < input.in > output.out
```

```bash
java -jar ~cs2030s/bin/checkstyle.jar -c ~cs2030s/bin/cs2030_checks.xml *.java
```

#  VIM

## Window

- `:vsp` vertical split
- `sp` horizontal split

> Use `Ctrl`+`W` `Shift`+`H` to navigate windows

## Other

- `:!sh` use terminal while in vim
- `gg=G` fix indentation of the whole file
- `:tabnew` filename to create a new tab

## Settings

- `mkdir .backup` make backup
- inside ~/.vimrc
	- syntax on
	- set number
	- set autoindent
	- set smartindent
	- set shiftwidth=2
	- set mouse +=a

# Jshell

- `jsh` file to test
- `cmd`+`l` to clear
- `/list` to see opened file

# JAVA

#### Interface

```java
public interface Immutator<R, P> {  
	public R invoke(P p);  
}
```

#### Throwing exception

```java
public Circle(Point c, double r) throws IllegalArgumentException {  
    if (r < 0) {  
      throw new IllegalArgumentException("radius cannot be negative.");  
    }  
    this.c = c;  
    this.r = r;  
  }  
}  
```
  
In the caller code:  

```java
try {  
    c = new Circle(point, radius);  
} catch (IllegalArgumentException e) {  
    System.err.println("Illegal arguement:" + e.getMessage());  
}
```

Custom exception

```java
class IllegalCircleException extends IllegalArgumentException {  
  Point center;  
  IllegalCircleException(String message) {  
    super(message);  
  }  
  IllegalCircleException(Point c, String message) {  
    super(message);  
    this.center = c;  
  }  
  @Override  
    public String toString() {  
      return "The circle centered at " + this.center + " cannot be created:" + getMessage();  
    }  
}
```

#### Method with multiple parameter input

```java
  @SafeVarargs
  public static <T> Reader<T> of(T... inputs) {
    List<T> currInputs = new ArrayList<T>();
    for (int i=0; i<inputs.length; i++) {
      currInputs.add(inputs[i]);
    }
    return new NonEmpty<>(currInputs);
  }
```
