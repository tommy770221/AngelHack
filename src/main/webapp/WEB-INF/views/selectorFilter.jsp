<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
    <head>
        <title>Select Filter</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container col-sm-12 col-offset-md-2 col-md-8 col-offset-lg-2 col-lg-8">
            <img src="./avatar" alt="" class="img-circle">
            <form>
                <div class="form-group">
                    <label for="lang" class="form-label">語系</label>
                    <select name="language" id="lang" class='form-input'>
                        <option value="zh-TW">中文</option>
                        <option value="en-US"></option>
                    </select>
                    <button type="submit" class="btn btn-default">確認</button>
                </div>
            </form>
        </div>
    </body>
</html>