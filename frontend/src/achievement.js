import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@polymer/iron-icon/iron-icon';

class Achievement extends PolymerElement {

    static get template() {
        return html`<style>
    #title {
        font-size: 18px;
    }

    #achievement {
        background-color: #101217;
        width: 435px;
        border-radius: 5px;
        padding: 8px;
        cursor: pointer;
    }

    #footer {
        display: flex;
        justify-content: space-between;
        font-size: 14px;
    }

    #experience {
        display: flex;
    }

    #xp {
        color: #22C4FA;
        margin-right: 8px;
        font-size: 18px;
    }

    #skill-points {
        color: #20E87B;
    }
    
    #actions{
        display: flex;
    }
    
    iron-icon.action {
        margin-left: 5px;
    }
</style>

<div id="achievement">

    <div id="title">[[title]]</div>

    <div id="footer">
        <div id="experience">
            <div id="xp">[[experience]]</div>
            <div id="skill-points">[[skills]]</div>
        </div>
        <div id="actions">
            <iron-icon class="action" icon="vaadin:star"></iron-icon>
            <iron-icon class="action" icon="vaadin:comment"></iron-icon>
            <iron-icon class="action" icon="vaadin:pencil"></iron-icon></div>
         </div>
    </div>
</div>`;
    }

    static get is() {
        return 'achievement-line';
    }
}

customElements.define(Achievement.is, Achievement);