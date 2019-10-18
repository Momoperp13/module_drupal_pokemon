<form method="post" class="std">
    {foreach from=$products  item=product}
    <div class ="form-group">
        <h2>{$product.title}</h2>
        <p>{$product.descriptionmodel}</p>
        <label  class="btn btn-success">Validate <input type="checkbox" id="id-active" class="badgebox" name="active_{$product.id_productmodel}"><span class="badge">✓</span></label>
    </div>
    {/foreach}
    {if $products!=null}
    <div class="form-group">
        <button type="submit" class="button" name="validproduct">Validate</button>
    </div>
    {/if}
</form>

