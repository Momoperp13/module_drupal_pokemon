<h2>{l s='Add a new product' mod='productadd'}</h2>

<form method="post" class="std">
    <div class="form-group">
            <label for="id-title">{l s='Title' mod='productadd'}</label>
            <input type="text" class="form-control" id="id-title" name ="title" placeholder="Title"/>
        
    </div>
    <div class="form-group">
            <label for="id-descriptionmodel">{l s='Description' mod='productadd'}</label>
            <textarea id="id-descriptionmodel" class="form-control" name ="despcriptionmodel" rows="5" cols="20"></textarea> 
        </div>
        <div class="form-group">
            <button type="submit" class="button" name="addnewproduct">{l s='Add product' mod='productaddn'}</button>
    </div>
    
</form>