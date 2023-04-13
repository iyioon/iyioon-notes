# Unix CLI 
---
## SSH Login to SOC Unix Account

```shell
ssh jhmoon@stu.comp.nus.edu.sg
ssh jhmoon@sunfire-r.comp.nus.edu.sg
```

## Transfer File and Download

```shell
scp -r /Users/jason/Documents/NUS/Module/CS2030/Lab8 jhmoon@stu.comp.nus.edu.sg:/home/j/jhmoon

scp -r jhmoon@stu.comp.nus.edu.sg:/home/j/jhmoon/Lab8 /Users/jason/Documents/NUS/Module/CS2030
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
java -jar [checkstyle.jar path] -c [s2030_checks.xml path] [java file]
```

[List_Stream_API](../Exam/List_Stream_API.pdf)

---
#  VIM

--- 

>[Website Guide](https://www.comp.nus.edu.sg/~CS2030S/vim-tips.html)

## Normal Mode

-   `W` jump to the beginning of the next word
-   `B` ump to the beginning of the previous word (reverse of `w`)
-   `E` jump to the end of the word (or next word when pressed again)
-   `F` char: search forward in the line and sit on the next matching char
-   `T` char: search forward in the line and sit on one space before the matching char
-   `Shift+4` ($) jump to the end of line
-   `0` jump to the beginning of the line
-   `Shift+6` (^) jump to the first non-blank character of the line
-   `Shift+5` (%) jump between matching parentheses
-  ` Ctrl+D` jump forward (Down) half page
-  ` Ctrl+F` jump Forward one page
-   `Ctrl+U` jump backward (Up) half page
-  ` Ctrl+B` jump Backward half page

## Edit mode

```
I:Insert S:Substitute A:Append O:Open new line 
```

**Tips:**
Repeating the same command twice means applying it to the whole line
Shift usually means applying the action until the end of the line

## Window

- `:vsp` vertical split
- `sp` horizontal split

> Use `Ctrl`+`W` `Shift`+`H` to navigate windows

## Other

- `:!sh` use terminal while in vim
- `gg=G` fix indentation of the whole file
- `:tabnew` filename to create a new tab

## Settings and Plugins

### Settings
- `mkdir .backup` make backup
- inside ~/.vimrc
	- syntax on
	- set number
	- set autoindent
	- set smartindent
	- set shiftwidth=2
	- set mouse +=a

---
# Jshell
---
- `jsh` file to test
- `cmd`+`l` to clear
- `/list` to see opened file