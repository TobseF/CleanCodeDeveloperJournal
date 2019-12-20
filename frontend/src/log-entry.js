import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@polymer/iron-icon/iron-icon';

class LogEntry extends PolymerElement {

    static get template() {
        return html`<style>
    #logentry {
        width: 380px;
    }

    #header {
        display: flex;
    }

    #title {
        flex-grow: 1;
    }

    #username {
        font-size: 18px;
    }
    
    #grade {
        font-size: 16px;
        line-height: 10px;
    }

    #date {
        color: gray;
        align-self: flex-end;
    }

    #content-head {
        display: flex;
        justify-content: space-between;
    }

    #topic {
        font-size: 18px;
    }

    #experience {
        align-self: flex-end;
    }

    #content {
        display: flex;
        flex-direction: column;
        background-color: var(--material-secondary-background-color);
        border-radius: 5px;
        padding: 5px;
    }

    #actions {
        align-self: flex-end;
    }
    
    #avatar{
        margin-right: 5px;
    }
    
    iron-icon.avatar {
        --iron-icon-height: 38px;
        --iron-icon-width: 38px;
    }

    iron-icon.type {
        --iron-icon-height: 18px;
        --iron-icon-width: 18px;
    }
    iron-icon.action {
        --iron-icon-height: 22px;
        --iron-icon-width: 22px;
    }
</style>

<div id="logentry">
    <div id="header">
        <div id="avatar">
            <iron-icon class="avatar" icon="vaadin:user"></iron-icon>
        </div>
        <div id="title">
            <div id="username">[[username]]</div>
            <div id="grade">[[grade]]</div>
        </div>
        <div id="date">[[date]]</div>
    </div>
    <div id="content">
        <div id="content-head">
            <div id="topic">[[topic]]</div>
            <div id="type">
                <iron-icon class="type" icon="vaadin:check-circle-o"></iron-icon>
            </div>
        </div>
        <div id="comment">[[comment]]</div>
        <div id="experience">[[experience]]</div>
        <div id="actions">
        <iron-icon class="action" icon="vaadin:close-small"></iron-icon>
        <iron-icon class="action" icon="vaadin:comment"></iron-icon>
        <iron-icon class="action" icon="vaadin:pencil"></iron-icon></div>
    </div>
</div>`;
    }

    static get is() {
        return 'log-entry';
    }
}

customElements.define(LogEntry.is, LogEntry);